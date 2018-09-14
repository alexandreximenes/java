package repository;

import domain.PalavrasInocentes;
import domain.Usuario;
import org.hibernate.Session;

public class PalavrasInocentesRepository {
    Session session = null;

    public Integer save(PalavrasInocentes palavrasInocentes) {
        session = new HibernateUtil().getSession();
        session.beginTransaction();

        Integer id = (Integer) session.save(palavrasInocentes);
        System.out.println("Salvo com sucesso!");

        session.getTransaction().commit();
        session.close();
        return id;
    }


    public void update(PalavrasInocentes palavrasInocentes) {
        session = new HibernateUtil().getSession();
        session.beginTransaction();

        session.saveOrUpdate(palavrasInocentes);
        System.out.println("Atualizado com sucesso!");
        session.getTransaction().commit();
        session.close();
    }

    public void delete(PalavrasInocentes palavrasInocentes) {
    }

    public void list(PalavrasInocentes palavrasInocentes) {
    }
}
