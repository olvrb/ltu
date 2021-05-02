import Application.Entities.User.Student;
import org.activejpa.enhancer.ActiveJpaAgentLoader;
import org.activejpa.jpa.JPA;
import org.apache.log4j.BasicConfigurator;

public class Application {
    private boolean setupDatabase() {
        ActiveJpaAgentLoader.instance()
                            .loadAgent();
        JPA.instance.addPersistenceUnit("library");
        return true;
    }

    public boolean Setup() {
        BasicConfigurator.configure();
        this.setupDatabase();

        Student stud = new Student();
        stud.persist();
        return true;
    }

    public boolean Run() {
        return true;
    }
}
