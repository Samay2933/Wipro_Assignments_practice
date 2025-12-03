class Book{
    private String title;
    private String author;
    private int year;
    private long ISSN;
    static int barcode;

    Book(String t,String a,int y, long i){
        this.title = t;
        this.author = a;
        this.year = y;
        this.ISSN = i;
    }

    public String getTitle(){
        return this.title;
    } 

    public void setTitle(String inputTitle){
        this.title=inputTitle;
    }
}