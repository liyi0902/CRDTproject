package editor;

import editor.controller.EditorController;
import editor.view.EditorFrame;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;
import editor.utils.ProcessUtil;

/**
 * The entrance of the whole project
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        Options options = new Options();


        options.addOption("lh",true,"local hostname");
        options.addOption("lp",true,"local port number");
        options.addOption("rp",true,"remote port number");
        options.addOption("rh",true,"remote hostname");
        options.addOption("u",true,"process id");

        CommandLineParser parser = new DefaultParser();

        CommandLine cmd = null;
        try {
            cmd = parser.parse( options, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(cmd.hasOption("lh")){
            Configuration.setLocalHost(cmd.getOptionValue("lh"));
        }

        if(cmd.hasOption("lp")){
            try{
                Configuration.setLocalPort(Integer.parseInt(cmd.getOptionValue("lp")));
            } catch (NumberFormatException e){
                log.info("-lp requires a port number, parsed: "+cmd.getOptionValue("lp"));
                System.exit(-1);
            }
        }

        if(cmd.hasOption("rh")){
            Configuration.setRemoteHost(cmd.getOptionValue("rh"));
        }

        if(cmd.hasOption("rp")){
            try{
                Configuration.setRemotePort(Integer.parseInt(cmd.getOptionValue("rp")));
            } catch (NumberFormatException e){
                log.error("-rp requires a port number, parsed: "+cmd.getOptionValue("rp"));
                System.exit(-1);
            }
        }

        if(cmd.hasOption("u")){
            Configuration.setProcessId(cmd.getOptionValue("u"));
        }
        else {
            // set the process id by random uuid
            Configuration.setProcessId(ProcessUtil.getUUID());
        }


        log.info("starting a new editor");


        EditorFrame.getInstance();

//        while (true){
//            try {
//                Thread.sleep(5000);
//                System.out.println(EditorFrame.getInstance().getTextArea().getCaretPosition());
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        }

    }
}
