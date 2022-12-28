package com.asstrans.agremiados.specification;

import com.asstrans.agremiados.model.Associado;
import com.asstrans.agremiados.model.Convenio;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

import org.springframework.data.jpa.domain.Specification;

public class SpecificationTemplate {

    @Spec(path = "fantasyName", spec = Like.class )
    public interface ConvenioSpec extends Specification<Convenio> { }

    @Or({
            @Spec(path = "matricula", spec = Equal.class),
            @Spec(path = "name", spec = Like.class)
    })
    public interface AssociadoSpec extends Specification<Associado> { }
}
