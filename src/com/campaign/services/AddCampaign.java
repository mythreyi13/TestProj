 
package com.campaign.services;



import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.campaign.model.Campaign;
import com.campaign.model.Partner;


@Path("/ad")
@Consumes("application/json")
@Produces("application/json")
public class AddCampaign {
	/**
     * Default constructor. 
     */
    public AddCampaign() {
        // TODO Auto-generated constructor stub
    }

    private CampaignManager campaignManager = new CampaignManager();

    /**
     * Retrieves representation of an instance of AddCampaign
     * @return an instance of String
     */
	@GET
	@Path("{partner_id}")
	@Produces("application/json")
	public Campaign getCampaign(@
			PathParam("partner_id") String partnerId) {
		
		Partner partner = new Partner();
		partner.setPartnerId(partnerId);
		return campaignManager.getCampaign(partner);
	}

	/**
     * POST method for updating or creating an instance of AddCampaign
     * @content content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public String saveCampaign(Campaign campaign){
		
		String response = null;
		if(null!= campaign.getPartnerId() && campaign.getDuration() > 0 && null !=
				campaign.getContent() && campaign.getContent().length() > 0) {
		
			campaign.setStartTime(new Date());
			Partner partner = new Partner();
			partner.setPartnerId(campaign.getPartnerId());
			try{
			campaignManager.addCampaign(partner, campaign);
			}catch(DuplicateCampaignException de){
				
				response = "An active campaign exists for this partner!";
			}catch(Exception e){
				response = "Unable to create the campaign";
			}
			if(response==null){
				response = "Created campaign successfully!";
			}
		}
		 
		return response;
		
	}
}