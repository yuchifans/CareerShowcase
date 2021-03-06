/*
 * MIT License
 *
 * Copyright (c) 2018 Ahmed AlAskalany
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.alaskalany.careershowcase.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EducationEntityTest {
    
    private static final int ID = 123;
    
    private static final String TITLE = "MSc in Master of Science";
    
    private static final String DEGREE = "Master of Science";
    
    private static final String STUDY_FIELD = "Nanotechnology";
    
    private static final String DESCRIPTION =
            "I have a B.Sc. in Electrical and Computer Engineering and studied for a M.Sc. in Nanotechnology. Worked in the software industry for 2 years, in Quality Assurance and Mobile App Development. My primary fields of expertise is Java development for Android applications and building mobile back-ends using Firebase and Google Cloud Platform.\n" +
            "\n" +
            "My goal is to work on building quality Android applications with reliable back-end services, and to become a world-class expert in this specialty. I combine my educational background and technical skills with a broad knowledge of various technologies to come up with highly efficient and cost-effective solutions. Through motivation and high work ethic, I create and thrive in an environment of collaboration and eagerness to achieve set goals.";
    
    private static final String INSTITUTION = "KTH Royal Institute of Technology";
    
    private static final String LOCATION = "Cairo, Egypt";
    
    private static final String DURATION = "August 2014 - September 2018";
    
    private static final String LOGO_URL =
            "https://firebasestorage.googleapis.com/v0/b/careershowcase-96976.appspot.com/o/images%2Flogo%2Fschool%2Famit_logo.png?alt=media&token=86499d5f-def9-4c8d-8d13-bc14b53b78db";
    
    private EducationEntity educationEntity;
    
    @Before
    public void setUp() throws Exception {
        
        educationEntity = new EducationEntity();
    }
    
    @After
    public void tearDown() throws Exception {
        
        educationEntity = null;
    }
    
    @Test
    public void getId() {
        
        int expected = ID;
        educationEntity.setId(expected);
        int actual = educationEntity.getId();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setId() {
        
        int expected = ID;
        educationEntity.setId(expected);
        int actual = educationEntity.getId();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getTitle() {
        
        String expected = TITLE;
        educationEntity.setTitle(expected);
        String actual = educationEntity.getTitle();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setTitle() {
        
        String expected = TITLE;
        educationEntity.setTitle(expected);
        String actual = educationEntity.getTitle();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getDegree() {
        
        String expected = DEGREE;
        educationEntity.setDegree(expected);
        String actual = educationEntity.getDegree();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setDegree() {
        
        String expected = DEGREE;
        educationEntity.setDegree(expected);
        String actual = educationEntity.getDegree();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getStudyField() {
        
        String expected = STUDY_FIELD;
        educationEntity.setStudyField(expected);
        String actual = educationEntity.getStudyField();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setStudyField() {
        
        String expected = STUDY_FIELD;
        educationEntity.setStudyField(expected);
        String actual = educationEntity.getStudyField();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getDescription() {
        
        String expected = DESCRIPTION;
        educationEntity.setDescription(expected);
        String actual = educationEntity.getDescription();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setDescription() {
        
        String expected = DESCRIPTION;
        educationEntity.setDescription(expected);
        String actual = educationEntity.getDescription();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getInstitution() {
        
        String expected = INSTITUTION;
        educationEntity.setInstitution(expected);
        String actual = educationEntity.getInstitution();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setInstitution() {
        
        String expected = INSTITUTION;
        educationEntity.setInstitution(expected);
        String actual = educationEntity.getInstitution();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getLocation() {
        
        String expected = LOCATION;
        educationEntity.setLocation(expected);
        String actual = educationEntity.getLocation();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setLocation() {
        
        String expected = LOCATION;
        educationEntity.setLocation(expected);
        String actual = educationEntity.getLocation();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getDuration() {
        
        String expected = DURATION;
        educationEntity.setDuration(expected);
        String actual = educationEntity.getDuration();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setDuration() {
        
        String expected = DURATION;
        educationEntity.setDuration(expected);
        String actual = educationEntity.getDuration();
        assertEquals(expected, actual);
    }
    
    @Test
    public void getLogoUrl() {
        
        String expected = LOGO_URL;
        educationEntity.setLogoUrl(expected);
        String actual = educationEntity.getLogoUrl();
        assertEquals(expected, actual);
    }
    
    @Test
    public void setLogoUrl() {
        
        String expected = LOGO_URL;
        educationEntity.setLogoUrl(expected);
        String actual = educationEntity.getLogoUrl();
        assertEquals(expected, actual);
    }
}