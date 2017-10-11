package com.example.gradle;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GradleApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test(expected = NullPointerException.class)
    public void testLinkedList() {
        LinkedList linkedList = mock(LinkedList.class);
        Mockito.when(linkedList.get(0)).thenThrow(new NullPointerException());
        linkedList.get(0);
    }

    @Test
    @Ignore
    public void testAddList() {
        List<String> mockedList = mock(List.class);

        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
        verify(mockedList).add("two");
        verify(mockedList).clear();
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testAndroidProperties() {
        Properties properties = mock(Properties.class);
        when(properties.get("anddroid")).thenThrow(new IllegalArgumentException());

        System.out.println(properties.get("android"));
    }

    @Test
    public void testSomeMock() {
        Customer customer = mock(Customer.class);
        customer.setFirstName("some name 12");
        verify(customer).setFirstName("some name 12");


    }

}
