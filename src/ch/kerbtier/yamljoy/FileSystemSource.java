package ch.kerbtier.yamljoy;

import java.io.File;
import java.nio.charset.Charset;

public abstract class FileSystemSource implements Source {

  private File file;
  private Charset charset;

  public FileSystemSource(File file, Charset charset) {
    this.file = file;
    this.charset = charset;
  }

  public FileSystemSource(File file) {
    this(file, Charset.defaultCharset());
  }
  
  File getFile() {
    return file;
  }

  Charset getCharset() {
    return charset;
  }
  
  @Override
  public String getKey() {
    String name = file.getName();
    if(name.indexOf(".") != -1) {
      name = name.substring(0, name.indexOf("."));
    }
    
    if(name.equals("") || name.equals("_")) {
      name = null;
    }
    
    return name;
  }
}
