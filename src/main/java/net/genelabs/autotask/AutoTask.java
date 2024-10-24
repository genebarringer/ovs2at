package net.genelabs.autotask;

import net.genelabs.models.ATNote;
import net.genelabs.ovsdata.OVS;
import net.genelabs.utility.Utilities;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoTask {
    private static Logger logger = LoggerFactory.getLogger(AutoTask.class);
    private Utilities utilities = new Utilities();
    public void addNoteToTicket(ATNote note) throws Exception {
        JSONObject jo = new JSONObject();
        jo.put("description", note.getDescription());
        jo.put("ticketID", note.getAT_ticket_id());
        jo.put("noteType", note.getNoteType());
        jo.put("publish", note.getPublish());
        jo.put("title", note.getTitle());
        jo.put("createDateTime", note.getCreated().toString());
        logger.info("addNoteToTicket - jo: " + jo.toString());
        String body = jo.toString();
        String url = "https://webservices22.autotask.net/ATServicesRest/V1.0/Tickets/"
        + note.getAT_ticket_id() + "/Notes";

        String results = utilities.callATRestAPI(url, "POST", body);
    }
}
