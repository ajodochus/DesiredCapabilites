package pages;

public class SaBlob {
	
	private String css;
	  private String text;
	  private String href;
	  private String id;
	
	public SaBlob(String css, String text, String href, String id) {
		this.css = css;
		this.text = text;
		this.href = href;
		this.id = id;
		
	}

	public String getCss(){
	     return css;
	}

	public void setCss(String css){
	     this.css = css;
	}
	
	
	public String getText(){
	     return text;
	}
	public void setText(String text){
	     this.text = text;
	}
	
	public String getHref(){
	     return href;
	}
	public void setHref(String href){
	     this.href = href;
	}

	public String getId(){
	     return id;
	}
	public void setId(String id){
	     this.id = id;
	}
}
