package com.campaign.model;

public class Partner {

	private String partnerId;
	
	private String partnerName;
	
	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	@Override
    public boolean equals(Object other){    	
    	
    	if(null != other){
    		Partner obj = (Partner)other;
    		if(null != obj.getPartnerId() && obj.getPartnerId().equals(this.partnerId)){
    		return true;
    		}
    	}
    	
    	return false;
    }
	
	public int hashCode(){
		
		return partnerId.hashCode();
	} 
	
}
