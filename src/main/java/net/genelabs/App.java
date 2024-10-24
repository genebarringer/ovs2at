package net.genelabs;

import net.genelabs.autotask.AutoTask;
import net.genelabs.models.ATNote;
import net.genelabs.ovsdata.OVS;
import net.genelabs.utility.Utilities;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger logger = LoggerFactory.getLogger(App.class);
    private static final Utilities u = new Utilities();
    public static void main( String[] args ) throws Exception {
        OVS ovs = new OVS();
        AutoTask autoTask = new AutoTask();

        List<ATNote> ticketNotes = new ArrayList<>();
        try {
            ticketNotes = ovs.getTicketCommentsById(23);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        logger.info("comments has " + ticketNotes.size() + " entries");
        for (ATNote ticketNote : ticketNotes) {

            ticketNote.setNoteType(1);
            ticketNote.setPublish(1);
            ticketNote.setTitle("ORIGINAL COMMENT DATE - " + ticketNote.getCreated());
            ticketNote.setAT_ticket_id(9752);

            autoTask.addNoteToTicket(ticketNote);
        }
        logger.info("Hello World !!");
    }
}
