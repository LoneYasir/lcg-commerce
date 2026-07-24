    package com.lcg.backend.repository;

    import com.lcg.backend.entity.Category;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface CategoryRepository extends JpaRepository<Category, Long> {
    }