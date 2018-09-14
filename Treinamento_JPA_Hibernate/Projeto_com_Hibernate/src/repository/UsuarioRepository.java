package repository;

import domain.Usuario;
import org.hibernate.Session;

public class UsuarioRepository {
    Session session = null;

    public Integer save(Usuario user) {
        session = new HibernateUtil().getSession();
        session.beginTransaction();

        Integer id = (Integer) session.save(user);
        System.out.println("Salvo com sucesso!");

        session.getTransaction().commit();
        session.close();
        return id;
    }


    public void update(Usuario user) {
        session = new HibernateUtil().getSession();
        session.beginTransaction();

        session.saveOrUpdate(user);
        System.out.println("Atualizado com sucesso!");
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Usuario user) {
    }

    public void list(Usuario user) {
    }
}
