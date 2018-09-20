import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.JoinedSubclassFkSecondPass;

import javax.swing.*;
import java.util.List;

public class Exercise8 {
    private SessionFactory sessionFactory = null;

    // Creating SessionFactory using 4.2 version of Hibernate
    public void initSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory();
        }
    }

    public static void main(String[] args) {
        Exercise8 manager = new Exercise8();
        manager.initSessionFactory();

        Game game = new Game();

        manager.setGame(game);

        manager.findAll();

    }

    public void setGame(Game game) {

        game.setId(Integer.parseInt(JOptionPane.showInputDialog("Please enter the id")));
        game.setTitle(JOptionPane.showInputDialog("Please enter the Title"));
        game.setPublisher(JOptionPane.showInputDialog("Please enter the Publisher"));
        game.setAge(Integer.parseInt(JOptionPane.showInputDialog("Please enter the age rating")));

        persistGame(game);
    }

    public void persistGame(Game game) {
        Transaction tx = null;
        Session session = sessionFactory.getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.save(game);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            throw ex;
        } finally {
            session.close();
        }

    }
    private void findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Game> games = session.createQuery("from Game").list();
        session.getTransaction().commit();
        for (int i = 0; i < games.size(); i++) {
            System.out.println(games.get(i).getTitle());
        }
    }
}
