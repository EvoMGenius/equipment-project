package org.apatrios.model.dictoinary;

import lombok.*;
import org.apatrios.model.services.Photo;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class ModelBike extends BaseDictionary {
    /** Вес велосипеда */
    String weight;

    /** Максимальная нагрузка */
    String maxLoad;

    /** Запас хода */
    String range;

    /** Максимальная скорость */
    String maxSpeed;

    /** * Список фотографий велосипеда */
    @ElementCollection
    @CollectionTable(
            name = "model_bike_photo",
            joinColumns = @JoinColumn(name = "model_bike_id")
    )
    List<Photo> photo = new ArrayList<>();
}
