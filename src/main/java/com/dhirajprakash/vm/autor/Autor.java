package com.dhirajprakash.vm.autor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTOR")
public class Autor {
	
	 @Id
	    @Column(name = "ID")
	    private Integer id;

	    @Column(name = "NOME")
	    private String nome;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		
	    
	    

}
