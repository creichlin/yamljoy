package ch.kerbtier.yamljoy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileSource extends FileSystemSource {

  public FileSource(File file, Charset charset) {
    super(file, charset);
  }

  @Override
  public Iterator<String> iterator() {
    try {
      FileInputStream fip = new FileInputStream(getFile());

      BufferedReader reader = new BufferedReader(new InputStreamReader(fip, getCharset()));
      
      List<String> lines = new ArrayList<String>();
      String line;
      while((line = reader.readLine()) != null) {
        lines.add(line);
      }
      reader.close();
      return lines.iterator();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
