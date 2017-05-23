package examples.sda.todoapp.data;

/**
 * Created by angelika on 23.05.17.
 */

public class TaskEntity {
    //TODO stworzyć pola w naszej bazie danych
    private Integer id;
    private String title;
    private String description;
    private Boolean completed;

    public TaskEntity(Integer id, String title, String description, Boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
