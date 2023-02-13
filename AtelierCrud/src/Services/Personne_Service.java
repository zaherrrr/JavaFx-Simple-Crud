package Services;

import Entities.Personne;
import Interfaces.IService;
import Utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Personne_Service implements IService<Personne> {
    private final Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public void ajouter(Personne personne) {
        try{
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO PERSONNE (nom,prenom,contact) values (?,?,?)");
            ps.setString(1,personne.getNom());
            ps.setString(2,personne.getPrenom());
            ps.setString(3,personne.getContact());
            ps.executeUpdate();
        }catch (Exception ignored){
        }
    }

    @Override
    public void supprimer(Personne personne) {
        try{
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM PERSONNE WHERE ID = ?");
            ps.setInt(1,personne.getId());
            ps.executeUpdate();
        }catch (Exception ignored){

        }
    }

    @Override
    public void modifier(Personne personne) {
        try{
            PreparedStatement ps = cnx.prepareStatement("UPDATE PERSONNE SET nom = ?, prenom = ?,contact =? WHERE ID = ?");
            ps.setString(1,personne.getNom());
            ps.setString(2,personne.getPrenom());
            ps.setString(3,personne.getContact());
            ps.setInt(4,personne.getId());
            ps.executeUpdate();
        }catch (Exception ignored){
        }
    }

    @Override
    public List<Personne> afficher() {
        try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PERSONNE WHERE 1");
            List<Personne> personnages = new ArrayList<>();
            while(rs.next()){
                personnages.add(new Personne(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
            return personnages;
        }catch (Exception ignored){
            return null;
        }
    }

    public void clear() {
        try{
            Statement st = cnx.createStatement();
            st.execute("Truncate table personne;");
        }catch (Exception ignored){

        }
    }
}
