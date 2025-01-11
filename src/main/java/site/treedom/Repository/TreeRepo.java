package site.treedom.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import site.treedom.Model.NodeDOM;

public interface TreeRepo extends MongoRepository<NodeDOM, String> {

}
