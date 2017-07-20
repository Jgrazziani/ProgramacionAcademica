package ve.edu.ucab.fing.info.services.file;

import WebService.HorarioRecurso;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import WebService.ProfesorRecurso;

@Path("/v1")
public class FileService {

    public static final String FILE_SERVER_LOCATION = "C:/Users/el_je_000/Documents/Prueba-carga/"; // CAMBIAR...
    // http://localhost:8080/file-service/api/v1/download
    @GET
    @Path("/download")
    public Response downloadFile() {

        // set file (and path) to be download
        File file = new File(FILE_SERVER_LOCATION + "what-are-conversational-bots.pdf");

        ResponseBuilder responseBuilder = Response.ok((Object) file);
        responseBuilder.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        return responseBuilder.build();
    }

    // http://localhost:8080/file-service/api/v1/upload
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("uploadFile") InputStream fileInputStream,
            @FormDataParam("uploadFile") FormDataContentDisposition fileFormDataContentDisposition) throws Exception {

        String fileName = null;
        String uploadFilePath = null;

        try {
            fileName = fileFormDataContentDisposition.getFileName();
            uploadFilePath = writeToFileServer(fileInputStream, fileName);
            ReadFile(uploadFilePath);            
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            // Liberar recursos en caso de ser necesario...
        }

        return Response.ok("El archivo fue cargado exitosamente en " + uploadFilePath).build();
    }

    /**
     * Escribe un flujo de entrada (input stream) al "servidor de archivos"
     *
     * @param inputStream
     * @param fileName
     * @throws IOException
     */
    private String writeToFileServer(InputStream inputStream, String fileName) throws IOException {

        OutputStream outputStream = null;
        String qualifiedUploadFilePath = FILE_SERVER_LOCATION + fileName;

        try {
            outputStream = new FileOutputStream(new File(qualifiedUploadFilePath));
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            outputStream.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            // Liberar recursos en caso de ser necesario...
            outputStream.close();
        }
        return qualifiedUploadFilePath;
    }
    
    private static void ReadFile(String filePath) throws Exception{
        //System.out.println("File path"+filePath);
        File f = new File(filePath);
        try {
            Workbook wb = Workbook.getWorkbook(f);
            Sheet s = wb.getSheet(0);
            int row = s.getRows();
            int col = s.getColumns();
            List<String> profesores = new ArrayList<>();
            for (int i = 0; i< row;i++){
                for (int j = 0; j<col;j++){
                    Cell c = s.getCell(j, i);
                    if("PROFESOR".equals(c.getContents())){
                        for (int fila = 1; fila<row; fila++){
                            Cell cp = s.getCell(j, fila);
                            if(!profesores.contains(cp.getContents())){
                                profesores.add(cp.getContents());
                            }                    
                        }                    
                        //System.out.println("Lista "+profesores.size());
                        String consultar_profesor = ReadList(profesores,filePath);
                        System.out.println(consultar_profesor);
                    }

                }
                System.out.println("");
            }
        }
        catch(Exception e){
            throw e;
        }        
    }
    private static String ReadList(List<String> profesores,String path) throws Exception{
        //System.out.println("READ");
        for (int i= 0; i<profesores.size();i++){
            System.out.println(profesores.get(i));
            try{
                //Response create = ProfesorRecurso.createProfesores(profesores.get(i));
                //System.out.println("create "+create);
                System.out.println("No llamar a daoprofesor");
            }catch(Exception e)
            {
                throw e;
            }
            ReadFileInformation(path,profesores.get(i));            
        }
        return "Profesores leidos correctamente";
    }
    private static void ReadFileInformation(String filePath,String profesor) throws Exception{
        //System.out.println("File path"+filePath);
        File f = new File(filePath);
        try {
        Workbook wb = Workbook.getWorkbook(f);
        Sheet s = wb.getSheet(0);
        int row = s.getRows();
        int col = s.getColumns();
        List<String> materias = new ArrayList<>();
        for (int i = 0; i< row;i++){
            for (int j = 0; j<col;j++){
                Cell c = s.getCell(j, i);
                if(profesor.equals(c.getContents())){
                   System.out.print(c.getContents()+"\t\t");
                    for (int p = 0; p<col ;p++){
                        Cell profesorlist = s.getCell(p, i);
                        Cell header = s.getCell(p, 0);
                        //System.out.println("informacion academica "+header.getContents() +" "+ profesorlist.getContents()+"\t\t");
                        //materias.add("{"+header.getContents()+"}"+"{"+profesorlist.getContents()+"}");
                        materias.add("{"+profesorlist.getContents()+"}");
                    }
                    //System.out.print("columna "+c.getColumn()+"\t\t");
                    //System.out.print("fila "+c.getRow()+"\t\t");
                }                
            }                   
            System.out.println("");
        }
         //ReadListMat(materias);
         Response create = HorarioRecurso.createHorario(materias.toString());
        }
        catch(Exception e){
            throw e;
        }        
    }

    private static void ReadListMat(List<String> Lista) throws Exception{
            for (int i = 0; i<Lista.size() ;i++){
                System.out.println("materias "+ Lista.get(i));
            }
    }    
}
