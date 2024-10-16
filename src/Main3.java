import java.util.ArrayList;
import java.util.List;


interface IPrototype {
    IPrototype clone();
}

class Section implements IPrototype {
    private String title;
    private String text;

    public Section(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public IPrototype clone() {
        return new Section(this.title, this.text);
    }

    @Override
    public String toString() {
        return "Section: " + title + "\nText: " + text;
    }
}




class Image implements IPrototype {
    private String url;

    public Image(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public IPrototype clone() {
        return new Image(this.url);
    }

    @Override
    public String toString() {
        return "Image URL: " + url;
    }
}




class Document implements IPrototype {
    private String title;
    private String content;
    private List<Section> sections;
    private List<Image> images;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
        this.sections = new ArrayList<>();
        this.images = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void addSection(Section section) {
        this.sections.add(section);
    }

    public List<Image> getImages() {
        return images;
    }

    public void addImage(Image image) {
        this.images.add(image);
    }

    @Override
    public IPrototype clone() {
        Document clonedDocument = new Document(this.title, this.content);
        for (Section section : this.sections) {
            clonedDocument.addSection((Section) section.clone());
        }
        for (Image image : this.images) {
            clonedDocument.addImage((Image) image.clone());
        }
        return clonedDocument;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Document: ").append(title).append("\nContent: ").append(content).append("\n");
        sb.append("Sections:\n");
        for (Section section : sections) {
            sb.append(section).append("\n");
        }
        sb.append("Images:\n");
        for (Image image : images) {
            sb.append(image).append("\n");
        }
        return sb.toString();
    }
}


class DocumentManager {
    public Document createDocument(IPrototype prototype) {
        return (Document) prototype.clone();
    }
}




public class Main3 {
    public static void main(String[] args) {
        Document originalDocument = new Document("Оригинал документ", "Оригинальный документ.");
        originalDocument.addSection(new Section("Инструкция", "Инструкция докусента."));
        originalDocument.addImage(new Image("http://example.com/image1.jpg"));

        System.out.println("Оригинальный документ:");
        System.out.println(originalDocument);


        DocumentManager manager = new DocumentManager();


        Document clonedDocument = manager.createDocument(originalDocument);
        clonedDocument.setTitle("Клон документ");
        clonedDocument.addSection(new Section("Консультация", "Секция консультаций."));
        clonedDocument.addImage(new Image("http://example.com/image2.jpg"));

        System.out.println("\nКлон документ:");
        System.out.println(clonedDocument);

        // Оригинальный документ не изменился
        System.out.println("\nОригинальный документ после клонирования:");
        System.out.println(originalDocument);
        
    }
}
