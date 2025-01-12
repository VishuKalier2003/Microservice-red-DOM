package site.treedom.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import site.treedom.Model.Template;

public interface TemplateRepo extends MongoRepository<Template, String> {

}
