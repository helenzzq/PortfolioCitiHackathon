package com.citi.training.portofolioManager.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public interface Investment {
    @Id
    public String getTicker();
    public void setTicker(String ticker);

    public String getCurrency();
    public void setCurrency(String currency);

    public Double getQuantity() ;

    public void setQuantity(Double quantity);
    public Double getCostPerShare();

    public void setCostPerShare(Double costPerShare);

    public Double getMarketPrice();
    public void setMarketPrice(Double marketPrice);
    public Double getMarketValue();

    public void setMarketValue(Double marketValue);

    public Double getProfitNLoss();
    public void setProfitNLoss(Double profitNLoss);

    public Double getPercentRetained();

    public void setPercentRetained(Double percentRetained);

    public Double getPercentInPort();

    public void setPercentInPort(Double percentInPort);

    public Integer getPortfolioId();
    public void setPortfolioId(Integer portfolioId);
}
