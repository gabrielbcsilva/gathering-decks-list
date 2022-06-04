package com.web.mtg.GatheringDecks.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.web.mtg.GatheringDecks.repositories.UsersRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTest {
  @Autowired
  private UsersRepo repo;

  @Test
	void salvaUsuNoBancoDeDados() {
    limpaCriaUsuario();
    assertEquals(1, repo.count());
	}

  @Test
	void atualizaRegistro() {
    User usu = limpaCriaUsuario();

    String novaSenha = "123456";
    usu.setPassword(novaSenha);
    repo.save(usu);

    assertEquals(novaSenha, repo.findById(usu.getId()).get().getPassword());
	}

  @Test
	void buscaLoginSenha() {
    User usu = limpaCriaUsuario();
    assertEquals(true, repo.login(usu.getEmail(), usu.getPassword()) != null);
	}

  @Test
	void existePorId() {
    User usu = limpaCriaUsuario();
    assertEquals(true, repo.exist(usu.getId()));
	}

  @Test
	void apagarUsuario() {
    User usu = limpaCriaUsuario();
    repo.delete(usu);
    assertEquals(0, repo.count());
	}

  private User limpaCriaUsuario() {
    repo.deleteAll(repo.findAll());

    User usu = new User();
    usu.setName("Gabriel");
    usu.setEmail("gabriel@email.com");
    usu.setPassword("1234");
    usu.setObs("um teste de unidade");
    repo.save(usu);

    return usu;
  }

}
