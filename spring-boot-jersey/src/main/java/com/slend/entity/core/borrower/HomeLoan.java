package com.slend.entity.core.borrower;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "s1_homeloan")
@Entity
public class HomeLoan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(columnDefinition="VARCHAR(20)")
	@Enumerated(EnumType.STRING)
	private AboutProperty aboutProperty;
	
	@Column(columnDefinition="VARCHAR(20)")
	@Enumerated(EnumType.STRING)
	private PropertyType propertyType;
	
	private String builderName;
	private String homeCost;
	private String constructionCost;
	private String plotCost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AboutProperty getAboutProperty() {
		return aboutProperty;
	}

	public void setAboutProperty(AboutProperty aboutProperty) {
		this.aboutProperty = aboutProperty;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public String getBuilderName() {
		return builderName;
	}

	public void setBuilderName(String builderName) {
		this.builderName = builderName;
	}

	public String getHomeCost() {
		return homeCost;
	}

	public void setHomeCost(String homeCost) {
		this.homeCost = homeCost;
	}

	public String getConstructionCost() {
		return constructionCost;
	}

	public void setConstructionCost(String constructionCost) {
		this.constructionCost = constructionCost;
	}

	public String getPlotCost() {
		return plotCost;
	}

	public void setPlotCost(String plotCost) {
		this.plotCost = plotCost;
	}

}
