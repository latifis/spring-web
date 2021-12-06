package com.latif.web.product.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "bni_product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 255)
    private String name;

    @Column //kalau mau ganti nama tinggal => column(name = "desc")
    private String description;

    @Column
    private Double price;

    @Column(name = "createAt")
    @CreationTimestamp
    private Date createAt;

    @Column(name = "updateAt")
    @UpdateTimestamp
    private Date updateAt;
}
