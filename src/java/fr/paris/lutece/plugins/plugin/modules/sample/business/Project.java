/*
 * Copyright (c) 2002-2022, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.plugin.modules.sample.business;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Date;
import javax.validation.constraints.NotNull;
/**
 * This is the business class for the object Project
 */ 
public class Project implements Serializable
{
    private static final long serialVersionUID = 1L;

    // Variables declarations 
    private int _nId;
    
    @NotEmpty( message = "#i18n{module.plugin.sample.validation.project.Title.notEmpty}" )
    @Size( max = 50 , message = "#i18n{module.plugin.sample.validation.project.Title.size}" ) 
    private String _strTitle;
    
    @NotEmpty( message = "#i18n{module.plugin.sample.validation.project.Description.notEmpty}" )
    @Size( max = 255 , message = "#i18n{module.plugin.sample.validation.project.Description.size}" ) 
    private String _strDescription;
    @NotNull( message = "#i18n{portal.validation.message.notEmpty}" )
    private Date _dateRangeOfPublicationDate;
    
    @Size( max = 255 , message = "#i18n{module.plugin.sample.validation.project.Date.size}" ) 
    private String _strDate;
    
    @Size( max = 255 , message = "#i18n{module.plugin.sample.validation.project.Choice.size}" ) 
    private String _strChoice;

    /**
     * Returns the Id
     * @return The Id
     */
    public int getId( )
    {
        return _nId;
    }

    /**
     * Sets the Id
     * @param nId The Id
     */ 
    public void setId( int nId )
    {
        _nId = nId;
    }
    
    /**
     * Returns the Title
     * @return The Title
     */
    public String getTitle( )
    {
        return _strTitle;
    }

    /**
     * Sets the Title
     * @param strTitle The Title
     */ 
    public void setTitle( String strTitle )
    {
        _strTitle = strTitle;
    }
    
    
    /**
     * Returns the Description
     * @return The Description
     */
    public String getDescription( )
    {
        return _strDescription;
    }

    /**
     * Sets the Description
     * @param strDescription The Description
     */ 
    public void setDescription( String strDescription )
    {
        _strDescription = strDescription;
    }
    
    
    /**
     * Returns the RangeOfPublicationDate
     * @return The RangeOfPublicationDate
     */
    public Date getRangeOfPublicationDate( )
    {
        return _dateRangeOfPublicationDate;
    }

    /**
     * Sets the RangeOfPublicationDate
     * @param dateRangeOfPublicationDate The RangeOfPublicationDate
     */ 
    public void setRangeOfPublicationDate( Date dateRangeOfPublicationDate )
    {
        _dateRangeOfPublicationDate = dateRangeOfPublicationDate;
    }
    
    
    /**
     * Returns the Date
     * @return The Date
     */
    public String getDate( )
    {
        return _strDate;
    }

    /**
     * Sets the Date
     * @param strDate The Date
     */ 
    public void setDate( String strDate )
    {
        _strDate = strDate;
    }
    
    
    /**
     * Returns the Choice
     * @return The Choice
     */
    public String getChoice( )
    {
        return _strChoice;
    }

    /**
     * Sets the Choice
     * @param strChoice The Choice
     */ 
    public void setChoice( String strChoice )
    {
        _strChoice = strChoice;
    }

}
