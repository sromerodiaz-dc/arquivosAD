import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Metodos {
    // Se crea el objeto vacio file
    File file;

    // Metodos
    public void setFile (String cadena) {
        try {
            file = new File(cadena);
            file = new File(file.getAbsolutePath());
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n no existe");
        }
    }

    public void setFile (String cadena, String nombre) {
        try {
            file = new File(cadena);
            // Construir la ruta completa del archivo
            File filePath = new File(file, nombre);
            file = new File(filePath.getAbsolutePath());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eDirectorio(String cadena) {
        setFile(cadena);
        if (file.isDirectory()) System.out.println("es directorio");
        else System.out.println("no es un directorio");
    }

    public void eFicheiro(String cadena) {
        setFile(cadena);
        if (file.isFile()) System.out.println("es ficheiro");
        else System.out.println("no es un ficheiro");
    }

    public void creaDirectorio(String cadena) {
        setFile(cadena);
        if (!file.isDirectory()) {
            file.mkdir();
        }
    }

    public void creaFicheiro(String cadena, String nombre) throws IOException {
        setFile(cadena);
        if (!file.isDirectory()) {
            file.mkdir();
        }

        setFile(cadena,nombre);
        if (!file.isFile()) file.createNewFile();
    }

    public void modoAcceso (String cadena, String nombre) {
        setFile(cadena, nombre);
        if (file.canRead() && file.canWrite()) {
            System.out.println("Escritura y Lectura");
        } else if (file.canRead()) {
            System.out.println("No se puede leer el archivo");
        } else if (file.canWrite()) {
            System.out.println("No se puede escribir el archivo");
        } else System.out.println("No se puede ni leer ni escribir el archivo");
    }

    public void calculaLonxitude (String cadena, String nombre) {
        setFile(cadena, nombre);
        System.out.println(file.length());
    }

    /*
     * 7) metodo  mLectura (dirName, fileName)
     * dado a ruta absoluta  e nome dun archivo ,este metodo  debe facer o arquivo de so lectura
     */

    public void mLectura (String cadena, String nombre) {
        setFile(cadena, nombre);
        file.mkdir();
        file.setReadOnly();
    }

    /*
     * 8) metodo  mEscritura (dirName, fileName)
     * dado a ruta e nome dun archivo ,este metodo debe facer posible escribir no arquivoo.
     */

    public void mEscritura (String cadena, String nombre) {
        setFile(cadena, nombre);
        file.setWritable(true);
        System.out.println(file.canRead());
    }

    /*
     * 9) metodo  borraFicheiro(dirName, fileName)
     * dado a ruta e nome dun archivo debe eliminalo se e que existe senon lanzar a mensaxe ficheiro inexistente
     */

    public void borraFicheiro (String cadena, String nombre) {
        setFile(cadena, nombre);
        file.delete();
    }

    /*
     * 10) metodo  borraDirectorio(dirName)
     * dada una ruta debe eliminala se e que existe senon lanzar a mensaxe 'ruta inexistente ou con descencencia'
     */

    public void borraDir (String cadena) {
        setFile(cadena);
        file.delete();
        System.out.println(file.exists());
    }

    /*
     * 11) metodo mContido(dirName) que amose arquivos e directorios de primeiro nivel dunha ruta absoluta dada
     */

    public void mContido (String cadena) {
        setFile(cadena);
        for (File file : file.listFiles()) {
            System.out.println(file.getName());
        }
    }

    public File[] mContido2 (String cadena) {
        setFile(cadena);
        return file.listFiles();
    }

    public File getFile () {
        return file;
    }

    public void borrarFile (File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                borrarFile(file.listFiles());
            }
            file.delete();
        }
    }

    /* 12)(Opcional) metodo recur(File) que amose arquivos e subdirectorios do directorio que se lle pase como obxecto File.
     * */

    public void recur(File file) {
        System.out.println(file.getAbsolutePath());  // Mostrar la ruta completa

        if (!file.exists()) {
            System.out.println("No se encontró el archivo o directorio");
        } else {
            if (file.isDirectory()) {
                System.out.println("Directorio: " + file.getName());

                // Obtener los archivos dentro del directorio
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.isDirectory()) {
                            // Recursivamente recorrer subdirectorios
                            recur(f);
                        } else {
                            // Imprimir los archivos
                            System.out.println("Archivo: " + f.getName());
                        }
                    }
                }
            } else {
                System.out.println("Archivo: " + file.getName());
            }
        }
    }


    /*Escribe*/

    public void writeFile(String cadena) throws IOException {
        Writer writer = new FileWriter(file);
        writer.write(cadena);
        writer.close();
    }
}
