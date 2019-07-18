package com.testTask.app.jsonResponses;

public class Promotions {
	
	    private String MinimumPhotoCount;

	    private String Description;

	    private String Price;

	    private String Id;

	    private String Name;

	    public String getMinimumPhotoCount ()
	    {
	        return MinimumPhotoCount;
	    }

	    public void setMinimumPhotoCount (String MinimumPhotoCount)
	    {
	        this.MinimumPhotoCount = MinimumPhotoCount;
	    }

	    public String getDescription ()
	    {
	        return Description;
	    }

	    public void setDescription (String Description)
	    {
	        this.Description = Description;
	    }

	    public String getPrice ()
	    {
	        return Price;
	    }

	    public void setPrice (String Price)
	    {
	        this.Price = Price;
	    }

	    public String getId ()
	    {
	        return Id;
	    }

	    public void setId (String Id)
	    {
	        this.Id = Id;
	    }

	    public String getName ()
	    {
	        return Name;
	    }

	    public void setName (String Name)
	    {
	        this.Name = Name;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [MinimumPhotoCount = "+MinimumPhotoCount+", Description = "+Description+", Price = "+Price+", Id = "+Id+", Name = "+Name+"]";
	    }
}
