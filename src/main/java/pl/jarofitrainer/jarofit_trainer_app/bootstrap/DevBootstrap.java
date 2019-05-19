package pl.jarofitrainer.jarofit_trainer_app.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.jarofitrainer.jarofit_trainer_app.model.Role;
import pl.jarofitrainer.jarofit_trainer_app.model.User;
import pl.jarofitrainer.jarofit_trainer_app.repository.RoleRepository;
import pl.jarofitrainer.jarofit_trainer_app.repository.UserRepository;

@Component
public class DevBootstrap  implements ApplicationListener<ContextRefreshedEvent> {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public DevBootstrap(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        User admin_naftovyk = new User("admin _naftovyk", "$2a$10$gFC0dw4pdBtR38HNcWnwQOoeA5jBNdWo5ABz30IIxZXMzB.Xr8Uee");
        Role roleAdmin = new Role ("ADMIN");
        admin_naftovyk.getRoles().add(roleAdmin);
        roleAdmin.getUsers().add(admin_naftovyk);

        userRepository.save(admin_naftovyk);
        roleRepository.save(roleAdmin);

        User aan = new User("aan", "$2a$10$qrkciPL9qeMrOvTTO/Bsn.IDh9aNP5gPDS8hK81oKUzL21jmd.byOll");
        Role roleUser = new Role ("USER");
        aan.getRoles().add(roleUser);
//        roleAdmin.getUsers().add(admin_naftovyk);

        userRepository.save(aan);
        roleRepository.save(roleUser);
    }
}
