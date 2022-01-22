package in.bonakula.projects.service;

import in.bonakula.projects.data.Extensions;
import in.bonakula.projects.repo.ExtensionsRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExtensionsService {
    @Resource
    private ExtensionsRepo extensionsRepo;
    public List<Extensions> getAllExtensions(){
        for (Extensions extensions : extensionsRepo.findAll()) {
            replaceUnneccesaryChars(extensions);
        }
        return extensionsRepo.findAll();
    }

    private void replaceUnneccesaryChars(Extensions extensions) {



        if(extensions.getExtname().endsWith("-")){
            extensions.setExtname(extensions.getExtname().substring(0,extensions.getExtname().length()-1));
            extensionsRepo.save(extensions);
        }

        if(extensions.getExtname().startsWith("(")){
            extensions.setExtname(extensions.getExtname().substring(1,extensions.getExtname().length()));
            extensionsRepo.save(extensions);
        }

        if(extensions.getExtname().endsWith(")")){
            extensions.setExtname(extensions.getExtname().substring(0,extensions.getExtname().length()-1));
            extensionsRepo.save(extensions);
        }
    }

    public Extensions getExtensionsByName(String extname) {
        return extensionsRepo.findByExtname(extname);
    }
}
