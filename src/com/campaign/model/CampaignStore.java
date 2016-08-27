package com.campaign.model;

import java.util.HashMap;

public class CampaignStore {

	private static HashMap<Partner, Campaign> campaignStore = new HashMap<Partner,Campaign>();
	
	public static Campaign getCampaign(Partner partner) {
		
		Campaign campaign = null;
		if(null != partner) {
			campaign = campaignStore.get(partner);
		}		
		return campaign;
	}
	
	
	public static synchronized void addCampaign(Partner partner, Campaign campaign) {
		
		if(null!= partner && null!= campaign){
			campaignStore.put(partner, campaign);
		}
	}
}
