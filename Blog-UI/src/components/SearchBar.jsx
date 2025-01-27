import React from 'react'
import { useState } from 'react';

const SearchBar = ({ onChange }) => {

    const [query, setQuery] = useState("");

    const handleSearch = (e) => {
        e.preventDefault();
        onChange(query);
    };

    return (
        <form onSubmit={handleSearch}>
            <input
                type="text"
                placeholder="Enter topic name ..."
                value={query}
                onChange={(e) => setQuery(e.target.value)}
            />
            <button style={{margin:'10px'}} type="submit">Search</button>
        </form>
    )
}

export default SearchBar