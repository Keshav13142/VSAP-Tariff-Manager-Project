package com.examly.springapp.Services;

import com.examly.springapp.Models.ExpenseModel;
import com.examly.springapp.Repository.ExpenseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseService {
    
    @Autowired
    private ExpenseRepository expenseRepository;
    public List<ExpenseModel> findAll(){
        return this.expenseRepository.findAll();
    }
    public ExpenseModel[] findById(int id)
    {
        return this.expenseRepository.findAllExpenseByEmpId(id);
    }
    public void deleteExpense(String id)
    {
        this.expenseRepository.deleteById(id);
    }
    public String updateExpense(ExpenseModel expense)
    {
        this.expenseRepository.save(expense);
        return "Expense Updated";
    }
    public String addExpense(ExpenseModel expense)
    {
        this.expenseRepository.save(expense);
        return "Expense Added";
    }
    public Long getSumOfExpenses(int id)
    {
        return this.expenseRepository.findCurrentMonthExpenses(id);
    }
    public List <ExpenseModel> getCurrentExpense(int id)
    {
        return this.expenseRepository.getCurrentMonthExpenses(id);
    }
}
