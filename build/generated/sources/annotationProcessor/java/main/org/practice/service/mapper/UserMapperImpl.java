package org.practice.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import org.practice.entity.UserEntity;
import org.practice.entity.UserRoleAssignment;
import org.practice.service.model.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-08T08:49:10+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.18 (Oracle Corporation)"
)
@ApplicationScoped
public class UserMapperImpl implements UserMapper {

    @Override
    public User toDTO(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( entity.getId() );
        user.firstName( entity.getFirstName() );
        user.lastName( entity.getLastName() );
        user.username( entity.getUsername() );
        user.password( entity.getPassword() );
        user.email( entity.getEmail() );
        user.tel( entity.getTel() );
        user.address( entity.getAddress() );
        user.dob( entity.getDob() );
        user.gender( entity.getGender() );
        user.profileImg( entity.getProfileImg() );
        user.balance( entity.getBalance() );
        user.registeredDate( entity.getRegisteredDate() );
        user.active( entity.isActive() );
        List<UserRoleAssignment> list = entity.getRoles();
        if ( list != null ) {
            user.roles( new ArrayList<UserRoleAssignment>( list ) );
        }

        return user.build();
    }

    @Override
    public List<User> toDTOList(List<UserEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( entityList.size() );
        for ( UserEntity userEntity : entityList ) {
            list.add( toDTO( userEntity ) );
        }

        return list;
    }
}
