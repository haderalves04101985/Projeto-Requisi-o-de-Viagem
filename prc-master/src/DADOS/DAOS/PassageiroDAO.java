
package DADOS.DAOS;

import UTIL.JPAUtil;
import dados_entidades.Passageiro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
        
public class PassageiroDAO {
    public void save_passag(Passageiro p){
        
        EntityManager gerenciador =JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.persist(p);
        gerenciador.getTransaction().commit();
        
    }
    
    public List<Passageiro> listar() {

        EntityManager gerenciador = JPAUtil.getGerenciador();
        TypedQuery consulta = gerenciador.createQuery(
                "Select a from Passageiro a", Passageiro.class);
        return consulta.getResultList();
        
    }
    
    public void editar(Passageiro p){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.merge(p);
        gerenciador.getTransaction().commit();
    }
    
    public void excluir(Passageiro p){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        p=gerenciador.merge(p);
        gerenciador.remove(p);
        gerenciador.getTransaction().commit();
    }
    public List<Passageiro> buscar(String n){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        TypedQuery consulta = gerenciador.createQuery(
                "Select a from Passageiro a where a.nome like :nome", Passageiro.class);
        consulta.setParameter("nome", n+"%");
        return consulta.getResultList();
    }
    
    
}
