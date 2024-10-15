package com.example.Blocos3D.Service;

import com.example.Blocos3D.domain.pedido.Pedido;
import com.example.Blocos3D.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarPedido(Long id, Pedido pedido) {
        return pedidoRepository.findById(id)
                .map(p -> {
                    p.setAndares(pedido.getAndares());
                    p.setCor1(pedido.getCor1());
                    p.setCor2(pedido.getCor2());
                    p.setCor3(pedido.getCor3());
                    p.setDesenho1(pedido.getDesenho1());
                    p.setDesenho2(pedido.getDesenho2());
                    p.setDesenho3(pedido.getDesenho3());
                    return pedidoRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public void excluirPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
