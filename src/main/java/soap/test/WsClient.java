package soap.test;

import java.math.BigDecimal;

import org.tempuri.CResultado;
import org.tempuri.CServico;
import org.tempuri.CalcPrecoPrazoWS;
import org.tempuri.CalcPrecoPrazoWSSoap;

public class WsClient {
    private static final Item items[] = {
            new Item("Item A", "0.3", BigDecimal.valueOf(3.0), BigDecimal.valueOf(11.0), BigDecimal.valueOf(16.0)),
            new Item("Item B", "1.0", BigDecimal.valueOf(20.0), BigDecimal.valueOf(25.0), BigDecimal.valueOf(30.0))
    };

    public enum Servico {
        PAC("41106", "PAC sem contrato"),
        SEDEX_A_COBRAR("40010", "SEDEX sem contrato"),
        SEDEX_10("40215", "SEDEX 10, sem contrato"),
        SEDEX_HOJE("40290", "SEDEX Hoje, sem contrato");

        String codigo;
        String descricao;

        Servico(String codigo, String descricao) {
            this.codigo = codigo;
            this.descricao = descricao;
        }

        public static Servico findByCodigo(String codigo) {
            for (Servico servico : values()) {
                if (servico.codigo.equals(codigo))
                    return servico;
            }
            return null;
        }
    }

    public static void main (String[] args) {
        calculate("88052600", "01011100", items[0]);
        calculate("88052600", "01011100", items[1]);
    }


    public static void calculate(String cepOrigem, String cepDestino, Item item) {
        CalcPrecoPrazoWS ws = new CalcPrecoPrazoWS();
        CalcPrecoPrazoWSSoap soap = ws.getCalcPrecoPrazoWSSoap();
        CResultado cr = soap.calcPrecoPrazo(null, null, "41106,40010", "69900320", "01011100", item.getPeso(), 1, item.getComprimento(), item.getAltura(), item.getLargura(), BigDecimal.ZERO, "N", BigDecimal.valueOf(0), "N");

        System.out.println("====  " + item.getDescricao() + "  ====");

        for (CServico cs : cr.getServicos().getCServico()) {
            System.out.println(Servico.findByCodigo(String.valueOf(cs.getCodigo())).descricao + " => " + cs.getValor()
                    + " (entrega em " + cs.getPrazoEntrega() + " dias)");
        }
    }
}

