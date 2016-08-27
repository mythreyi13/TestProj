package com.campaign.services;

import java.util.Date;

import com.campaign.model.Campaign;
import com.campaign.model.CampaignStore;
import com.campaign.model.Partner;

public class CampaignManager {

	public Campaign getCampaign(Partner partner) {	
	
		Campaign campaign = null;
		if(null != partner) {
			campaign = CampaignStore.getCampaign(partner);
			if(null!=campaign){
				long time = campaign.getStartTime().getTime()+campaign.getDuration();
				long now = new Date().getTime();
				if(now > time){
					campaign = null;
				}
			}
		}		
		return campaign;
	}
	
	
	public void addCampaign(Partner partner, Campaign campaign) throws DuplicateCampaignException{
		
		if(null!= partner && null!= campaign){
			Campaign existing = getCampaign(partner);
			if(null != existing){
				throw new DuplicateCampaignException();
			}else{
				CampaignStore.addCampaign(partner, campaign);
				
			}
			
		}
	}
	
}
