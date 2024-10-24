package net.genelabs.ovsdata;

import net.genelabs.models.ATNote;
import net.genelabs.utility.Utilities;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class OVS {

    private static Logger logger = LoggerFactory.getLogger(OVS.class);
    private static final Utilities u = new Utilities();
    public List<ATNote> getTicketCommentsById(int id) throws Exception {
        logger.info("getTicketById - start");
        logger.info("getTicketById id: " + id);
        List<ATNote> notes = new ArrayList<>();
        String data;
        data = u.callOVSRestAPI("http://localhost:8080/parent_tickets/225465");

        JSONObject jsonObject = new JSONObject(data);
        logger.debug("getTicketById:jsonObject: " + jsonObject.toString());
        JSONArray childTicket = jsonObject.getJSONArray("child_TICKETS");
        logger.info("getTicketById:childTicket length " + childTicket.length());

        for (int i = 0; i<childTicket.length(); i++) {
            ATNote note = new ATNote();
            String parentTicketId = childTicket.getJSONObject(i).getString("parent_TICKET_ID");
            String comment = childTicket.getJSONObject(i).getString("comment");
            String created = childTicket.getJSONObject(i).getString("created");
            note.setDescription(comment);
            note.setCreated(created);
            notes.add(note);
            logger.info("getTicketById:****************************************");
            logger.info("getTicketById:created is " + created);
            logger.info("getTicketById:comment is " + parentTicketId + " - " + comment);
        }

        logger.info("getTicketById - end");
        return notes;
    }
}
