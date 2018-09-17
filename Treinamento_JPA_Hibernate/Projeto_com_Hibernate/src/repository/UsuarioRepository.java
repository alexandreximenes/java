package repository;

import domain.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Usuario> list(Usuario user) {
        session = new HibernateUtil().getSession();

        session.beginTransaction();

//        Usuario usuario = session.get(Usuario.class, user.getId());
        Query q = session.createQuery("SELECT u FROM Usuario u left join fetch u.enderecos");
        List<Usuario> usuarios = q.list();

        session.getTransaction().commit();

        session.close();

        return filter(usuarios);
    }

    private List<Usuario> filter(List<Usuario> usuarios) {
        //Filtrar usuarios que tenham endereço cadastrado..// só pra praticar hehe
        return usuarios.stream()
                .filter(u -> u.getEnderecoEmbedded() != null && u.getDataBatismo() != null)
                .collect(Collectors.toList());

    }
}
