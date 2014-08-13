package com.baldurtech.turnt.octo.adventure;

import java.util.Map;
import java.util.HashMap;

public class ContactAction extends Action {
    final private ContactManager contactManager;

    public ContactAction(ActionContext actionContext) {
        this(actionContext, new ContactManagerImpl());
    }

    public ContactAction(ActionContext actionContext, ContactManager contactManager) {
        super(actionContext);
        this.contactManager = contactManager;
    }

    public void index() {
        println("Hi, contact!");
    }

    public Map<String, Object> show() {
        String paramId = actionContext.getParameter("id");
        if(paramId == null || paramId.trim().length() == 0) {
            actionContext.redirectAction("contact/list");
            return null;
        }
        Long id = Long.parseLong(paramId);
        final Contact contact = contactManager.getById(id);
        return new HashMap<String, Object>(){{
                put("contact", contact);
            }};
    }

    public void save() {
        final Contact contact = new Contact();
        contact.setName(actionContext.getParameter("name"));
        contact.setMobile(actionContext.getParameter("mobile"));
        contact.setVpmn(actionContext.getParameter("vpmn"));
        contact.setEmail(actionContext.getParameter("email"));
        contact.setHomeAddress(actionContext.getParameter("homeAddress"));
        contact.setOfficeAddress(actionContext.getParameter("officeAddress"));
        contact.setMemo(actionContext.getParameter("memo"));
        contact.setJob(actionContext.getParameter("job"));
        String paramJobLevel = actionContext.getParameter("jobLevel");
        if(paramJobLevel != null && paramJobLevel.trim().length() > 0) {
            contact.setJobLevel(Integer.parseInt(paramJobLevel));
        }

        Contact savedContact = contactManager.save(contact);
        if(savedContact.isPersistent()) {
            actionContext.redirectAction("contact/show?id=" + savedContact.getId());
        } else {
            actionContext.flashMessage("Cannot save Contact!");
            actionContext.forwardAction("contact/create", new HashMap<String, Object>(){{
                        put("contact", contact);
                    }});
        }
    }

    public Contact create() {
        return new Contact();
    }
}
