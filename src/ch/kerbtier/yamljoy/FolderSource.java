package ch.kerbtier.yamljoy;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FolderSource extends FileSystemSource {

  public FolderSource(File file, Charset charset) {
    super(file, charset);
  }

  public FolderSource(File file) {
    super(file);
  }

  @Override
  public Iterator<String> iterator() {
    
    List<String> lines = new ArrayList<String>();
    
    for(File file: getFile().listFiles()) {
      Source source = null;
      if(file.isDirectory()) {
        source = new FolderSource(file);
      } else {
        source = new FileSource(file, getCharset());
      }
      
      if(source.getKey() == null) {
        for(String line: source) {
          lines.add(line);
        }
      } else {
        lines.add(source.getKey() + ":");
        for(String line: source) {
          lines.add("  " + line);
        }
      }
    }
    
    return lines.iterator();
  }
}
