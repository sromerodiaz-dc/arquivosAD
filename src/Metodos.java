import java.io.File;
import java.io.IOException;

public class Metodos {
    // Se crea el objeto vacio file
    File file;

    // Metodos
    public void setFile (String cadena) {
        try {
            file = new File(cadena);
            file = new File(file.getAbsolutePath());
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        setFile(cadena, nombre);
        if (!file.isDirectory()) {
            file.mkdir();
        }

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
    }

    /** Metodos restantes
     * 6) metodo   calculaLonxitude(dirName, fileName)
     * dado a ruta absoluta  e nome dun archivo ,este metodo  debe : imprimir a lonxitude en bytes do mesmo
     *
     * 7) metodo  mLectura (dirName, fileName)
     * dado a ruta absoluta  e nome dun archivo ,este metodo  debe facer o arquivo de so lectura
     *
     * 8) metodo  mEscritura (dirName, fileName)
     * dado a ruta e nome dun archivo ,este metodo debe facer posible escribir no arquivoo.
     *
     * 9) metodo  borraFicheiro(dirName, fileName)
     * dado a ruta e nome dun archivo debe eliminalo se e que existe senon lanzar a mensaxe ficheiro inexistente
     *
     * 10) metodo  borraDirectorio(dirName)
     * dada una ruta debe eliminala se e que existe senon lanzar a mensaxe 'ruta inexistente ou con descencencia'
     *
     * 11) metodo mContido(dirName) que amose arquivos e directorios de primeiro nivel dunha ruta absoluta dada
     *
     * 12)(Opcional) metodo recur(File) que amose arquivos e subdirectorios do directorio que se lle pase como obxecto File.
     * */
}
