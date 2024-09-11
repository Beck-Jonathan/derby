package com.beck.javaiii_kirkwood.budget_app.data;
import com.beck.javaiii_kirkwood.budget_app.models.Category_VM;
import com.beck.javaiii_kirkwood.budget_app.models.Category_VM;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository  extends JpaRepository<Category_VM, Integer>{
}
