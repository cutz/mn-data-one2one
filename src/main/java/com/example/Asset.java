package com.example;

import io.micronaut.data.annotation.EmbeddedId;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import jakarta.annotation.Nullable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@MappedEntity("asset")
public record Asset (
        @EmbeddedId
        AssetId id,

        String title,

        @Nullable
        @Relation(value = Relation.Kind.ONE_TO_ONE, cascade = Relation.Cascade.NONE)
        @JoinColumn(name="container_id", referencedColumnName = "container_id")
        @JoinColumn(name="asset_id", referencedColumnName = "asset_id")
        AssetMetadata metadata
) { }
