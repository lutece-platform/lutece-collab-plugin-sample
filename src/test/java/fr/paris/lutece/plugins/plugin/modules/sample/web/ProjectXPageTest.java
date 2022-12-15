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
 * SUBSTITUTE GOODS OR SERVICES LOSS OF USE, DATA, OR PROFITS OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */

package fr.paris.lutece.plugins.plugin.modules.sample.web;

import fr.paris.lutece.portal.service.admin.AccessDeniedException;
import fr.paris.lutece.test.LuteceTestCase;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import java.io.IOException;
import fr.paris.lutece.portal.service.security.SecurityTokenService;
import java.util.List;
import fr.paris.lutece.portal.service.message.SiteMessageException;
import fr.paris.lutece.portal.web.LocalVariables;
import java.sql.Date;
import fr.paris.lutece.util.date.DateUtil;
import fr.paris.lutece.portal.web.l10n.LocaleService;
import fr.paris.lutece.plugins.plugin.modules.sample.business.Project;
import fr.paris.lutece.plugins.plugin.modules.sample.business.ProjectHome;
/**
 * This is the business class test for the object Project
 */
public class ProjectXPageTest extends LuteceTestCase
{
    private static final String TITLE1 = "Title1";
    private static final String TITLE2 = "Title2";
    private static final String DESCRIPTION1 = "Description1";
    private static final String DESCRIPTION2 = "Description2";
	private static final Date RANGEOFPUBLICATIONDATE1 = new Date( 1000000l );
    private static final Date RANGEOFPUBLICATIONDATE2 = new Date( 2000000l );
    private static final String DATE1 = "Date1";
    private static final String DATE2 = "Date2";
    private static final String CHOICE1 = "Choice1";
    private static final String CHOICE2 = "Choice2";

public void testXPage(  ) throws AccessDeniedException, IOException
	{
        // Xpage create test
        MockHttpServletRequest request = new MockHttpServletRequest( );
		MockHttpServletResponse response = new MockHttpServletResponse( );
		MockServletConfig config = new MockServletConfig( );

		ProjectXPage xpage = new ProjectXPage( );
		assertNotNull( xpage.getCreateProject( request ) );
		
		request = new MockHttpServletRequest();
		request.addParameter( "token", SecurityTokenService.getInstance( ).getToken( request, "createProject" ));
		
		LocalVariables.setLocal(config, request, response);
		
		request.addParameter( "action" , "createProject" );
        request.addParameter( "title" , TITLE1 );
        request.addParameter( "description" , DESCRIPTION1 );
        request.addParameter( "range_of_publication_date" , DateUtil.getDateString( RANGEOFPUBLICATIONDATE1, LocaleService.getDefault( ) ) );
        request.addParameter( "date" , DATE1 );
        request.addParameter( "choice" , CHOICE1 );
		request.setMethod( "POST" );
		
		assertNotNull( xpage.doCreateProject( request ) );
		
		
		//modify Project	
		List<Integer> listIds = ProjectHome.getIdProjectsList(); 

		assertTrue( !listIds.isEmpty( ) );

		request = new MockHttpServletRequest();
		request.addParameter( "id", String.valueOf( listIds.get( 0 ) ) );

		assertNotNull( xpage.getModifyProject( request ) );

		response = new MockHttpServletResponse();
		request = new MockHttpServletRequest();
		LocalVariables.setLocal(config, request, response);
		
        request.addParameter( "title" , TITLE2 );
        request.addParameter( "description" , DESCRIPTION2 );
        request.addParameter( "range_of_publication_date" , DateUtil.getDateString( RANGEOFPUBLICATIONDATE2, LocaleService.getDefault( ) ) );
        request.addParameter( "date" , DATE2 );
        request.addParameter( "choice" , CHOICE2 );

		request.addParameter( "token", SecurityTokenService.getInstance( ).getToken( request, "modifyProject" ));
		request.addParameter( "id", String.valueOf( listIds.get( 0 ) ) );
		
		assertNotNull( xpage.doModifyProject( request ) );

		//do confirm remove Project
		request = new MockHttpServletRequest();
		request.addParameter( "action" , "confirmRemoveProject" );
		request.addParameter( "id", String.valueOf( listIds.get( 0 ) ) );
		request.addParameter( "token", SecurityTokenService.getInstance( ).getToken( request, "confirmRemoveProject" ));;
		request.setMethod("GET");

		try
		{
			xpage.getConfirmRemoveProject( request );
		}
		catch(Exception e)
		{
			assertTrue(e instanceof SiteMessageException);
		}

		//do remove Project
		response = new MockHttpServletResponse();
		request = new MockHttpServletRequest();
		LocalVariables.setLocal(config, request, response);
		request.addParameter( "action" , "removeProject" );
		request.addParameter( "token", SecurityTokenService.getInstance( ).getToken( request, "removeProject" ));
		request.addParameter( "id", String.valueOf( listIds.get( 0 ) ) );
		assertNotNull( xpage.doRemoveProject( request ) );

    }
    
}
