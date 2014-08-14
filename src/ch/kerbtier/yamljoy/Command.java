package ch.kerbtier.yamljoy;

import java.io.File;

public class Command {
  
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("One parameter is needed. The path to te folder which shoould be yamelized.");
    } else {
      FolderSource folderSource = new FolderSource(new File(args[0]));
      for (String line : folderSource) {
        System.out.println(line);
      }
    }
  }
}
