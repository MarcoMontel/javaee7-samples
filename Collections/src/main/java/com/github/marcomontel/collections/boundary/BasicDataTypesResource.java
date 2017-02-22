/*
 * Copyright (C) 2017 mmontel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.marcomontel.collections.boundary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author mmontel
 */
@Path("basic")
public class BasicDataTypesResource {
    @GET
    @Path("integers/range/{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIntegerRange(@PathParam("from") int from, @PathParam("to") int to) {
        ArrayList<Integer> range = IntStream.rangeClosed(from, to).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        return Response.ok(new GenericEntity<List<Integer>>(range){}).build();
    }
    
    @GET
    @Path("strings/range/{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStringRange(@PathParam("from") int from, @PathParam("to") int to) {
        List<String> range = IntStream.rangeClosed(from, to).mapToObj((int value) -> String.valueOf(value)).collect(Collectors.toList());
        return Response.ok(new GenericEntity<List<String>>(range){}).build();

    }
    
    @GET
    @Path("boolean/range")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooleanRange() {
        List<Boolean> range = Arrays.asList(new Boolean[]{true, false});
        return Response.ok(new GenericEntity<List<Boolean>>(range){}).build();
    }
    
    @GET
    @Path("doubles/range/{from}/{limit}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoubleRange(@PathParam("from") double from, @PathParam("limit") long to) {
        List<Double> range = DoubleStream.iterate(from, n -> n + from).limit(to).
                mapToObj((double value) -> value).collect(Collectors.toList());
        return Response.ok(new GenericEntity<List<Double>>(range){}).build();

    }
}
