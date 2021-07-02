package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BO.Conexao;
import BO.Gravacao;
import DTO.Anuncio;
import DTO.ListaAnuncios;

/**
 * Classe responsável por implementar a persistência no Banco de Dados utilizando injeção de dependência com a classe BO.Gravacao.
 *
 * @author Natasha Busnardo
 */
public class GravarBD implements Gravacao {

    private final String NOMEDATABELA = "Anuncio";

    @Override
    public boolean gravar(List<Anuncio> Anuncios) {

        for (Anuncio Anuncio : Anuncios) {

            try {
                Connection conn = Conexao.conectar();
                String sql = "INSERT INTO " + NOMEDATABELA
                        + " (nome,cliente,data_inicio,data_termino,investimento) VALUES (?,?,?,?,?);";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, Anuncio.getNome());
                ps.setString(2, Anuncio.getCliente());
                ps.setString(3, ListaAnuncios.DataForStringMySQL(Anuncio.getDataInicio()));
                ps.setString(4, ListaAnuncios.DataForStringMySQL(Anuncio.getDataTermino()));
                ps.setString(5, Integer.toString(Anuncio.getInvestimentoDia()));
                ps.executeUpdate();
                ps.close();
                conn.close();
                return true;
            } catch (Exception e) {
                System.err.println("Erro: " + e.toString());
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public List<Anuncio> ler() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Anuncio> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            // System.err.println("Erro: " + e.toString());
            // e.printStackTrace();
            return null;
        }
    }

    public List<Anuncio> montarLista(ResultSet rs) {
        List<Anuncio> listObj = new ArrayList<Anuncio>();
        try {
            while (rs.next()) {
                Anuncio obj = new Anuncio();
                obj.setNome(rs.getString("nome"));
                obj.setCliente(rs.getString("cliente"));
                obj.setDataInicio(ListaAnuncios.DataMySQLHoraDia(rs.getString("dataInicio")));
                obj.setDataTermino(ListaAnuncios.DataMySQLHoraDia(rs.getString("dataTermino")));
                obj.setInvestimentoDia(Integer.parseInt(rs.getString("investimentoDia")));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

}